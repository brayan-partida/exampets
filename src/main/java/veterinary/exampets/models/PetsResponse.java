package veterinary.exampets.models;

import veterinary.exampets.models.enums.Status;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class PetsResponse implements Serializable {

    String transactionId;
    LocalDateTime dateCreated;
    Status status;
    String name;

    public LocalDateTime getDateCreated() {
        return LocalDateTime.now();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
