package fi.jyu.ties4371.cottagequeryrdf;


import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.RDFDataMgr;
import org.eclipse.rdf4j.sparqlbuilder.core.Prefix;
import org.eclipse.rdf4j.sparqlbuilder.core.SparqlBuilder;
import org.eclipse.rdf4j.sparqlbuilder.rdf.Rdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.rdf4j.sparqlbuilder.rdf.Rdf.iri;

public class RdfDatabase {

    private static final String RDF_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final String XSD_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final String COTTAGE_NAMESPACE = "http://users.jyu.fi/~rakrbans/interface-of-things/index.owl#";

    private String rdfFilePath;

    private static String queryNamespace = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
            "PREFIX cottage: <http://users.jyu.fi/~rakrbans/interface-of-things/index.owl#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema>\n";

    public RdfDatabase(String rdfFilePath) {
        this.rdfFilePath = rdfFilePath;
    }

    public List<Map> searchForResult(SearchQuery searchQuery) {

        Model model = RDFDataMgr.loadModel(this.rdfFilePath);

        OntModelSpec ontModelSpec = OntModelSpec.OWL_DL_MEM;
        OntModel ontModel = ModelFactory.createOntologyModel(ontModelSpec, model);

        String queryString = queryNamespace +
                "SELECT ?cottage ?numberOfBedrooms ?nearestCity ?cottageId ?address ?imageURL ?distanceToLake ?distanceToNearestCity ?imageURL \n" +
                "WHERE {  ?cottage rdf:type cottage:Cottage .\n" +
                "         ?cottage cottage:nearestCity \"" + searchQuery.getCityName() + "\" ; cottage:nearestCity ?nearestCity .\n" +
                "         ?cottage cottage:numberOfBedrooms \"" + searchQuery.getNumberOfBedRooms() + "\" ; cottage:capacity ?numberOfBedrooms .\n" +
                "         ?cottage cottage:hasId ?cottageId .\n" +
                "         ?cottage cottage:distanceToNearestCity \"" + searchQuery.getDistanceToNearestCity() + "\" ; cottage:distanceToNearestCity ?distanceToNearestCity .\n" +
                "         ?cottage cottage:distanceToLake \"" + searchQuery.getDistanceToLake() + "\" ; cottage:distanceToLake ?distanceToLake .\n" +
                "         ?cottage cottage:hasAddress ?address.\n " +
                "         ?cottage cottage:cottageImageURL ?imageURL .\n" +
                "}";

        System.out.println(queryString);


       // cottage:cottage01 rdf:type cottage:Cottage; cottage:availability "true"^^xsd:boolean; cottage:hasId "01"; cottage:capacity "10"^^xsd:integer; cottage:numberOfBedrooms "4"; cottage:nearestCity "Kuhmo"; cottage:distanceToNearestCity "5"; cottage:distanceToLake "200"; cottage:hasAddress "Examplestreet"; cottage:cottageImageURL "https://dkvhmgvkwdd6n.cloudfront.net/wp-content/uploads/2017/02/10070555/Cottage-18_052-900x600.jpg" .

        Dataset dataset = DatasetFactory.create(ontModel);
        Query q = QueryFactory.create(queryString);

        QueryExecution qexec = QueryExecutionFactory.create(q, dataset);
        ResultSet resultSet = qexec.execSelect();


        List<Map> foundCottages = new ArrayList<>();





        while (resultSet.hasNext()) {
            QuerySolution row = (QuerySolution) resultSet.next();
            RDFNode city = row.get("nearestCity");
            RDFNode numberOfBedrooms = row.get("numberOfBedrooms");
            RDFNode address = row.get("address");
            RDFNode imageURL = row.get("imageURL");
            RDFNode distanceToLake = row.get("distanceToLake");
            RDFNode distanceToNearestCity = row.get("distanceToNearestCity");

            Map<String, String> result = new HashMap<>();


            result.put("numberOfPeople", searchQuery.getNumberOfPeople()+""); // capacity
            result.put("numberOfBedRooms",numberOfBedrooms.toString());
            result.put("distanceToLake", distanceToLake.toString());
            result.put("cityName", city.toString());
            result.put("distanceToNearestCity", distanceToNearestCity.toString());
            result.put("imageURL", imageURL.toString());
            result.put("address", address.toString());
            result.put("durationStay",searchQuery.getDurationOfStay()+"");


            foundCottages.add(result);

        }

        return foundCottages;


    }


}
