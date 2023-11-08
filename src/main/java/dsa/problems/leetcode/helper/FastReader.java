package dsa.problems.leetcode.helper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

@Slf4j
@RequiredArgsConstructor(onConstructor__ = @Autowired)
public class FastReader{
    private final BufferedReader bufferedReader;
    public FastReader() throws FileNotFoundException {
        this.bufferedReader = new BufferedReader(new FileReader("src/main/java/dsa/problems/leetcode/text_files/input.txt"));
    }
    public String next() {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            return stringTokenizer.nextToken();
        } catch (IOException e) {
            log.error("error in next()", e);
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(Objects.requireNonNull(next()));
    }

    public long nextLong() {
        return Long.parseLong(Objects.requireNonNull(next()));
    }

    public double nextDouble() {
        return Double.parseDouble(Objects.requireNonNull(next()));
    }

    public String nextLine() {
        try {
            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            log.error("error in nextLine()", e);
            return null;
        }
    }
}
