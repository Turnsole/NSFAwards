package com.lastminutedevice.nsfawards.models;

import java.util.List;

/**
 * Represents a full response from the nsf.gov api.
 *
 * Designed for Gson deserialization.
 */
public class AwardsResponse {
    private Response response;

    public AwardsResponse() {}

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public class Response {
        private List<Award> award;

        public Response() {}

        public List<Award> getAward() {
            return award;
        }

        public void setAward(List<Award> award) {
            this.award = award;
        }
    }
}
