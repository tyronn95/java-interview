package async;

import io.vavr.Tuple2;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import static async.AsyncTest.getCEOAndEnterprise;

public class Main {

    public static void main(String[] args) {
        String ceoIdToSearch = "ceo_2";
        CompletableFuture<Tuple2<Optional<Ceo>, Optional<Enterprise>>> resultFuture = getCEOAndEnterprise(ceoIdToSearch);

        resultFuture.thenAccept(result -> {
            Optional<Ceo> ceoOptional = result._1();
            Optional<Enterprise> enterpriseOptional = result._2();

            if (ceoOptional.isPresent() && enterpriseOptional.isPresent()) {
                System.out.println("CEO found: " + ceoOptional.get().getName());
                System.out.println("Enterprise found: " + enterpriseOptional.get().getName());
            } else {
                System.out.println("No CEO or Enterprise found for ID: " + ceoIdToSearch);
            }
        }).join();
    }
}
