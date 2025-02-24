package tech.biuldrun.spotify.entity;
// Enum class for user roles
public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private  String role;

     UserRole(String role) {
         this.role = role;
     }
     public String getRole() {
         return role;
     }
}
