package materialObjects;

import enums.SubjectContent;
import enums.SubjectType;

import java.util.Objects;

public class Subject{
    private final SubjectType type;
    private final String title;

    private Subject(Builder builder) {
        this.type = builder.type;
        this.title = builder.title;
    }

    public static class Builder {
        private SubjectType type;
        private String title;

        public Builder type(SubjectType type) {
            this.type = type;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }

    public SubjectType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public class Content {
        private SubjectContent content;

        public SubjectContent getContent() {
            return content;
        }

        public void setContent(SubjectContent content) {
            this.content = content;
        }

        public void eat() {
            System.out.println("Содержимое съедено");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return type == subject.type &&
                Objects.equals(title, subject.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
