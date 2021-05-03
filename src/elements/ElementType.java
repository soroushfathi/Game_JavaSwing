package elements;

public enum ElementType {
    BEAD{
        @Override
        public String toString() {
            return "Bead";
        }
    },WALL{
        @Override
        public String toString() {
            return "Wall";
        }
    },STAR{
        @Override
        public String toString() {
            return "Star";
        }
    },SNAIL{
        @Override
        public String toString() {
            return "Snail";
        }
    }
}
