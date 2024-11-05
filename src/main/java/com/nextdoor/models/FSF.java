/*
 * Copyright (c) 2024 Nika Beridze
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.nextdoor.models;

import java.util.Collection;

public class FSF extends NextDoorURLEncodedModel {
    private String title;
    private String description;
    private String price;
    private CategoryType category;
    private Collection<String> imageAttachments;

    public FSF() {

    }

    public FSF(String title, String description, String price, CategoryType category, Collection<String> imageAttachments) {
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

    public CategoryType getCategory() {
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

        public FSFBuilder setCategory(CategoryType category) {
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

    public enum CategoryType {
        APPLIANCES,
        AUTOMOTIVE,
        BABY_AND_KIDS,
        BICYCLES,
        CLOTHING,
        ELECTRONICS,
        FURNITURE,
        GARAGE_SALES,
        GARDEN,
        HOME_DECOR,
        HOME_SALES,
        IN_SEARCH_OF,
        MUSICAL_INSTRUMENTS,
        NEIGHBOR_MADE,
        NEIGHBOR_SERVICES,
        OTHER,
        PET_SUPPLIES,
        PROPERTY_RENTALS,
        SPORTS_AND_OUTDOORS,
        TICKETS,
        TOOLS,
        TOYS_AND_GAMES
    }
}
