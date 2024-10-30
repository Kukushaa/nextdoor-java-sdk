package com.nextdoor.models.advertising.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdUser extends NextDoorModel implements Serializable {
    @JsonProperty("user")
    private CurrentUser currentUser;

    @JsonProperty("profile")
    private Profile currentProfile;

    public AdUser() {

    }

    public AdUser(CurrentUser currentUser, Profile currentProfile) {
        this.currentUser = currentUser;
        this.currentProfile = currentProfile;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Profile implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String profileName;

        @JsonProperty("associated_user_ids")
        private List<String> associatedUserIds;

        @JsonProperty("payment_profile_id")
        private String paymentProfileId;

        @JsonProperty("is_ad_agency")
        private boolean isAdAgency;

        public Profile() {

        }

        public Profile(String id, String profileName, List<String> associatedUserIds, String paymentProfileId, boolean isAdAgency) {
            this.id = id;
            this.profileName = profileName;
            this.associatedUserIds = associatedUserIds;
            this.paymentProfileId = paymentProfileId;
            this.isAdAgency = isAdAgency;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProfileName() {
            return profileName;
        }

        public void setProfileName(String profileName) {
            this.profileName = profileName;
        }

        public List<String> getAssociatedUserIds() {
            return associatedUserIds;
        }

        public void setAssociatedUserIds(List<String> associatedUserIds) {
            this.associatedUserIds = associatedUserIds;
        }

        public String getPaymentProfileId() {
            return paymentProfileId;
        }

        public void setPaymentProfileId(String paymentProfileId) {
            this.paymentProfileId = paymentProfileId;
        }

        public boolean isAdAgency() {
            return isAdAgency;
        }

        public void setAdAgency(boolean adAgency) {
            isAdAgency = adAgency;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Profile profile = (Profile) object;
            return Objects.equals(id, profile.id) && Objects.equals(profileName, profile.profileName) && Objects.equals(associatedUserIds, profile.associatedUserIds) && Objects.equals(paymentProfileId, profile.paymentProfileId) && Objects.equals(isAdAgency, profile.isAdAgency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, profileName, associatedUserIds, paymentProfileId, isAdAgency);
        }

        @Override
        public String toString() {
            return "Profile{" +
                    "id='" + id + '\'' +
                    ", profileName='" + profileName + '\'' +
                    ", associatedUserIds=" + associatedUserIds +
                    ", paymentProfileId='" + paymentProfileId + '\'' +
                    ", isAdAgency='" + isAdAgency + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentUser implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String userName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("email_confirmed")
        private boolean emailConfirmed;

        @JsonProperty("advertisers_with_access")
        private List<AdvertisersWithAccess> advertisersWithAccess;

        public CurrentUser() {

        }

        public CurrentUser(String id, String userName, String email, boolean emailConfirmed, List<AdvertisersWithAccess> advertisersWithAccess) {
            this.id = id;
            this.userName = userName;
            this.email = email;
            this.emailConfirmed = emailConfirmed;
            this.advertisersWithAccess = advertisersWithAccess;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isEmailConfirmed() {
            return emailConfirmed;
        }

        public void setEmailConfirmed(boolean emailConfirmed) {
            this.emailConfirmed = emailConfirmed;
        }

        public List<AdvertisersWithAccess> getAdvertisersWithAccess() {
            return advertisersWithAccess;
        }

        public void setAdvertisersWithAccess(List<AdvertisersWithAccess> advertisersWithAccess) {
            this.advertisersWithAccess = advertisersWithAccess;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            CurrentUser currentUser = (CurrentUser) object;
            return emailConfirmed == currentUser.emailConfirmed && Objects.equals(id, currentUser.id) && Objects.equals(userName, currentUser.userName) && Objects.equals(email, currentUser.email) && Objects.equals(advertisersWithAccess, currentUser.advertisersWithAccess);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, userName, email, emailConfirmed, advertisersWithAccess);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", userName='" + userName + '\'' +
                    ", email='" + email + '\'' +
                    ", emailConfirmed=" + emailConfirmed +
                    ", advertisersWithAccess=" + advertisersWithAccess +
                    '}';
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdvertisersWithAccess implements Serializable {
            @JsonProperty("id")
            private String advertiserId;

            @JsonProperty("role")
            private String role;

            public AdvertisersWithAccess() {

            }

            public AdvertisersWithAccess(String advertiserId, String role) {
                this.advertiserId = advertiserId;
                this.role = role;
            }

            public String getAdvertiserId() {
                return advertiserId;
            }

            public void setAdvertiserId(String advertiserId) {
                this.advertiserId = advertiserId;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            @Override
            public boolean equals(Object object) {
                if (this == object) return true;
                if (object == null || getClass() != object.getClass()) return false;
                AdvertisersWithAccess that = (AdvertisersWithAccess) object;
                return Objects.equals(advertiserId, that.advertiserId) && Objects.equals(role, that.role);
            }

            @Override
            public int hashCode() {
                return Objects.hash(advertiserId, role);
            }

            @Override
            public String toString() {
                return "AdvertisersWithAccess{" +
                        "advertiserId='" + advertiserId + '\'' +
                        ", role='" + role + '\'' +
                        '}';
            }
        }
    }
}
