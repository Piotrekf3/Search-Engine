import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;

public class Searcher {
    public void search(String sQuery, IndexReader indexReader) {
        try {
            Query query = new QueryParser("content", new StandardAnalyzer()).parse(sQuery);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            TopDocs topDocs = indexSearcher.search(query,5);
            for(ScoreDoc doc : topDocs.scoreDocs) {
                System.out.println(doc.score);
                System.out.println(indexReader.document(doc.doc));
                System.out.println("-----------------------------");
            }
        }
        catch(ParseException | IOException e) {
            System.err.println("Error parsing query" + " " + e);
            e.printStackTrace();
        }
    }
}
