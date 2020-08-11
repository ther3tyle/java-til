package day07;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseModel {

    private final UUID id;
    private String prodName;
    private final LocalDateTime createdAt;

    public BaseModel(String prodName) {
        this.id = UUID.randomUUID();
        this.prodName = prodName;
        this.createdAt = LocalDateTime.now();
    }

    public void printUUID() {
        System.out.println(this.id);
    }

    public UUID getId() {
        return id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
