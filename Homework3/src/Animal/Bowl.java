package Animal;

public class Bowl {
        public int food;

        public Bowl(int food) {
            this.food = food;
        }

        public boolean decreaseFood(int amount) {
            if (food >= amount) {
                food -= amount;
                return true;
            } else {
                return false;
            }
        }

        public void addFood(int amount) {
            food += amount;
        }
    }

