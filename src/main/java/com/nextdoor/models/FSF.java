package com.nextdoor.models;

import java.util.Collection;

public class FSF extends NextDoorURLEncodedModel {
    private String title;
    private String description;
    private String price;
    private String category;
    private Collection<String> imageAttachments;

    public FSF() {

    }

    public FSF(String title, String description, String price, String category, Collection<String> imageAttachments) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageAttachments = imageAttachments;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Collection<String> getImageAttachments() {
        return imageAttachments;
    }

    public static FSFBuilder build() {
        return new FSFBuilder(new FSF());
    }

    public static class FSFBuilder {
        private final FSF fsf;

        public FSFBuilder(FSF fsf) {
            this.fsf = fsf;
        }

        public FSFBuilder setTitle(String title) {
            this.fsf.title = title;
            return this;
        }

        public FSFBuilder setDescription(String description) {
            this.fsf.description = description;
            return this;
        }

        public FSFBuilder setPrice(String price) {
            this.fsf.price = price;
            return this;
        }

        public FSFBuilder setCategory(String category) {
            this.fsf.category = category;
            return this;
        }

        public FSFBuilder setImageAttachments(Collection<String> imageAttachments) {
            this.fsf.imageAttachments = imageAttachments;
            return this;
        }

        public FSF build() {
            return this.fsf;
        }
    }
}
