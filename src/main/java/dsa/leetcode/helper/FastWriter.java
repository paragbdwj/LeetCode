package dsa.leetcode.helper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

@RequiredArgsConstructor(onConstructor__ = @Autowired)
public class FastWriter {
    private final BufferedWriter bufferedWriter;

    public FastWriter() throws IOException {
        this.bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/dsa/leetcode/text_files/output.txt"));
    }
    public void print(Object object) throws IOException {
        bufferedWriter.append("").append(String.valueOf(object));
    }

    public void println(Object object) throws IOException {
        print(object);
        bufferedWriter.append("\n");
    }

    public void close() throws IOException {
        bufferedWriter.close();
    }
}
