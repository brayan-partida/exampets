package veterinary.exampets.models;


import veterinary.exampets.models.enums.Status;

import java.util.List;

public class Pet {
    private Long id;
 //   private Category category;
    private String name; // Required
  //  private List<String> photoUrls; // Required
  //  private List<Tag> tags;
    private Status status;

    public Pet() {
    }

   /* public Pet(Long id, Category category, String name, List<String> photoUrls, List<Tag> tags, Status status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }*/

    // Getters and Setters for Pet
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  /*  public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }*/

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // --- Static Inner Class: Category ---
    public static class Category {
        private Long id;
        private String name;

        public Category() {
        }

        public Category(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // --- Static Inner Class: Tag ---
    public static class Tag {
        private Long id;
        private String name;

        public Tag() {
        }

        public Tag(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}