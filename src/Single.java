import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/temp")
public class Single extends HttpServlet {
    int count =0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i < 1_000_000; i++) {
            count++;
        }
        System.out.println(count);
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        URLConnection urlConnection=new URL("http://localhost:8080/temp").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}