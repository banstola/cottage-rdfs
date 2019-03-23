package fi.jyu.ties4371.cottagequeryrdf;

import org.apache.jena.base.Sys;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

public class RdfDatabase {

    private String rdfFilePath;

    private static String queryNamespace = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
            "PREFIX cottage: <http://example.org/ex>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema>\n";

    public RdfDatabase(String rdfFilePath) {
        this.rdfFilePath = rdfFilePath;
    }

    public void searchForResult(SearchQuery searchQuery) {

        Model model = RDFDataMgr.loadModel(this.rdfFilePath);

        OntModelSpec ontModelSpec = OntModelSpec.OWL_DL_MEM;
        OntModel ontModel = ModelFactory.createOntologyModel(ontModelSpec, model);

        String queryString = queryNamespace +
                "SELECT ?cottage \n" +
                "WHERE {  ?cottage rdf:type cottage:Cottage .\n" +
                "         ?cottage cottage:nearestCity \"" + searchQuery.getCityName() + "\" .\n" +
                "         ?cottage cottage:capacity \"" + searchQuery.getNumberOfPeople() + "\" .\n" +
                "         ?cottage cottage:numberOfBedrooms \"" + searchQuery.getNumberOfBedRooms() + "\" .\n" +
                "         ?cottage cottage:hasId ?cottageId .\n" +
                "         ?cottage cottage:nearestCity \"" + searchQuery.getCityName() + "\" .\n" +
                "         ?cottage cottage:distanceToNearestCity \"" + searchQuery.getDistanceToNearestCity() + "\" .\n" +
                "         ?cottage cottage:distanceToLake \"" + searchQuery.getDistanceToLake() + "\" .\n" +
                "         ?cottage cottage:hasAddress ?address.\n" +
                "         ?cottage cottage:cottageImageURL ?imageUrl" +
                "}";


        System.out.println(queryString);


        Dataset dataset = DatasetFactory.create(ontModel);
        Query q = QueryFactory.create(queryString);

        QueryExecution qexec = QueryExecutionFactory.create(q, dataset);
        ResultSet resultSet = qexec.execSelect();

        System.out.println("Results: ---");
        while (resultSet.hasNext()) {
            QuerySolution row = (QuerySolution) resultSet.next();
            RDFNode nextItemId = row.get("cottage");

            System.out.print("ItemID is: " + nextItemId.toString() + ".\n");

        }


    }


}
