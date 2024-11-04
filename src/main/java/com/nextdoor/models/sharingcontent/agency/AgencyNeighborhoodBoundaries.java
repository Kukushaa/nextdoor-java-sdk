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
package com.nextdoor.models.sharingcontent.agency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyNeighborhoodBoundaries extends NextDoorModel implements Serializable {
    @JsonProperty("has_next_page")
    private boolean hasNextPage;

    @JsonProperty("cursor")
    private String cursor;

    @JsonProperty("result")
    private List<AgencyBoundaries> result;

    public AgencyNeighborhoodBoundaries() {

    }

    public AgencyNeighborhoodBoundaries(boolean hasNextPage, String cursor, List<AgencyBoundaries> result) {
        this.hasNextPage = hasNextPage;
        this.cursor = cursor;
        this.result = result;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<AgencyBoundaries> getResult() {
        return result;
    }

    public void setResult(List<AgencyBoundaries> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AgencyNeighborhoodBoundaries{" +
                "hasNextPage=" + hasNextPage +
                ", cursor='" + cursor + '\'' +
                ", result=" + result +
                '}';
    }
}
