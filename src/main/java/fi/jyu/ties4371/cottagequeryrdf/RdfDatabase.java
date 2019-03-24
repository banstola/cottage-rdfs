package fi.jyu.ties4371.cottagequeryrdf;


import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.RDFDataMgr;
import org.eclipse.rdf4j.sparqlbuilder.core.Prefix;
import org.eclipse.rdf4j.sparqlbuilder.core.SparqlBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.rdf4j.sparqlbuilder.rdf.Rdf.iri;

public class RdfDatabase {

    private static final String RDF_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final String XSD_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final String COTTAGE_NAMESPACE = "http://example.org/ex#";

    private Prefix rdfPrefix;
    private Prefix cottagePrefix;
    private Prefix xsdPrefix;


    private String rdfFilePath;

    private static String queryNamespace = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
            "PREFIX cottage: <http://example.org/ex>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema>\n";

    public RdfDatabase(String rdfFilePath) {
        this.rdfFilePath = rdfFilePath;
        this.rdfPrefix = SparqlBuilder.prefix("rdf", iri(RDF_NAMESPACE));
        this.cottagePrefix = SparqlBuilder.prefix("xsd", iri(XSD_NAMESPACE));
        this.xsdPrefix = SparqlBuilder.prefix("cottage", iri(COTTAGE_NAMESPACE));
    }

    public List<Map> searchForResult(SearchQuery searchQuery) {

        Model model = RDFDataMgr.loadModel(this.rdfFilePath);

        OntModelSpec ontModelSpec = OntModelSpec.OWL_DL_MEM;
        OntModel ontModel = ModelFactory.createOntologyModel(ontModelSpec, model);

        String queryString = queryNamespace +
                "SELECT ?cottage ?numberOfBedrooms ?nearestCity ?cottageId ?address ?imageURL ?distanceToLake \n" +
                "WHERE {  ?cottage rdf:type cottage:Cottage .\n" +
                "         ?cottage cottage:nearestCity \"" + searchQuery.getCityName() + "\" .\n" +
                "         ?cottage cottage:capacity ?capacity .\n" +
                //  "         ?cottage cottage:numberOfBedrooms \"" + searchQuery.getNumberOfBedRooms() + "\" .\n" +
                //  "         ?cottage cottage:hasId ?cottageId .\n" +
                //  "         ?cottage cottage:nearestCity \"" + searchQuery.getCityName() + "\" .\n" +
                //  "         ?cottage cottage:distanceToNearestCity \"" + searchQuery.getDistanceToNearestCity() + "\" .\n" +
                //  "         ?cottage cottage:distanceToLake \"" + searchQuery.getDistanceToLake() + "\" .\n" +
                //  "         ?cottage cottage:hasAddress ?address.\n" +
                //  "         ?cottage cottage:cottageImageURL ?imageUrl" +

                //    "FILTER (?capacity >= 9) .\n"+

                "}";

        System.out.println(queryString);


        Dataset dataset = DatasetFactory.create(ontModel);
        Query q = QueryFactory.create(queryString);

        QueryExecution qexec = QueryExecutionFactory.create(q, dataset);
        ResultSet resultSet = qexec.execSelect();


        String numberOfBedrooms;
        String nearestCity;
        String address;
        String cottageId;
        String imageURL;
        Float distanceToLake;
        int capacity;


        List<Map> foundCottages = new ArrayList<>();

        Map<String, String> result1 = new HashMap<>();


        result1.put("numberOfPeople", "10"); // capacity
        result1.put("numberOfBedRooms", "5");
        result1.put("distanceToLake", "10");
        result1.put("cityName", "Kuhmo");
        result1.put("distanceToNearestCity", "10");
        result1.put("imageURL", "https://dkvhmgvkwdd6n.cloudfront.net/wp-content/uploads/2017/02/10070555/Cottage-18_052-900x600.jpg");
        result1.put("address", "Survontie 46 A 40520 Jyväskylä");


        foundCottages.add(result1);

        return foundCottages;


      /*  System.out.println("Results: ---");
        while (resultSet.hasNext()) {
            QuerySolution row = (QuerySolution) resultSet.next();
            RDFNode nextItemId = row.get("");



        }

*/
    }


}
