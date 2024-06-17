package async;

import io.vavr.Tuple2;
import java.util.Optional;
import java.util.List;
//import io.vavr.collection.List;
import io.vavr.control.Option;
import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    CompletableFuture<Option<Ceo>> future = new CompletableFuture<>();

    Optional<Ceo> ceoOptional = ceos.stream()
            .filter(ceo -> ceo.getId().equals(ceo_id))
            .findFirst();

    Option<Ceo> ceoOption = ceoOptional.map(Option::of).orElse(Option.none());
    future.complete(ceoOption);

    return future;
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    CompletableFuture<Option<Enterprise>> future = new CompletableFuture<>();

    Optional<Enterprise> enterpriseOptional = enterprises.stream()
            .filter(enterprise -> enterprise.getCeoId().equals(ceo_id))
            .findFirst();

    Option<Enterprise> enterpriseOption = enterpriseOptional.map(Option::of).orElse(Option.none());
    future.complete(enterpriseOption);

    return future;
  }

  public static CompletableFuture<Tuple2<Optional<Ceo>, Optional<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> {
      Optional<Ceo> ceoOptional = ceos.stream()
              .filter(ceo -> ceo.getId().equals(ceo_id))
              .findFirst();

      Optional<Enterprise> enterpriseOptional = enterprises.stream()
              .filter(enterprise -> enterprise.getCeoId().equals(ceo_id))
              .findFirst();

      return new Tuple2<>(ceoOptional, enterpriseOptional);
    });
  }
}
