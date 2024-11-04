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
package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomeTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("income_targeting")
    private List<Income> incomeTargeting;

    public IncomeTargeting() {
    }

    public IncomeTargeting(List<Income> incomeTargeting) {
        this.incomeTargeting = incomeTargeting;
    }

    public List<Income> getIncomeTargeting() {
        return incomeTargeting;
    }

    public void setIncomeTargeting(List<Income> incomeTargeting) {
        this.incomeTargeting = incomeTargeting;
    }

    @Override
    public String toString() {
        return "IncomeTargeting{" +
                "incomeTargeting=" + incomeTargeting +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Income implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Income() {
        }

        public Income(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Income{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
