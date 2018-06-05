import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class Indexer {
    private IndexReader indexReader;

    public Indexer() {
        try {
            indexReader = DirectoryReader.open(FSDirectory.open(Paths.get("data/index")));
        } catch (IOException e) {
            System.err.println("Error opening index" + e);
            e.printStackTrace();
        }
    }

        public IndexReader getIndexReader() {
            return indexReader;
        }
}
