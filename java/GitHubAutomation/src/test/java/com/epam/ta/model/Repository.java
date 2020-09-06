package com.epam.ta.model;

import java.util.Objects;

public class Repository {
    private String name;
    private String description;
    private boolean isPublic;
    private boolean hasReadme;
    private String gitignore;
    private String license;

    public Repository(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean hasReadme() {
        return hasReadme;
    }

    public void setHasReadme(boolean hasReadme) {
        this.hasReadme = hasReadme;
    }

    public String getGitignore() {
        return gitignore;
    }

    public void setGitignore(String gitignore) {
        this.gitignore = gitignore;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return isPublic == that.isPublic &&
                hasReadme == that.hasReadme &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(gitignore, that.gitignore) &&
                Objects.equals(license, that.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, isPublic, hasReadme, gitignore, license);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Repository{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", isPublic=").append(isPublic);
        sb.append(", hasReadme=").append(hasReadme);
        sb.append(", gitignore='").append(gitignore).append('\'');
        sb.append(", license='").append(license).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
