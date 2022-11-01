public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        double powerX = Math.pow(x2 - x1, 2);
        double powerY = Math.pow(y2 - y1, 2);
        double roundIt = roundedToHundredth(Math.sqrt(powerX + powerY));

        return roundIt;
    }


    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }


    public double slope() {

        return roundedToHundredth((double) (y1 - y2) / (x1 - x2));
    }


    public String equation() {


        double dec = slope() % 1;
        String addSub = "+ ";
        double yintercept = yIntercept();
        String yintStr = "" + yIntercept();

        if (yintercept < 0) {
            addSub = "- ";
            yintStr = "" + Math.abs(yintercept);
        } else if (yintercept == 0) {
            addSub = "";
            yintStr = "";
        }

        if (dec == 0.0) { //if whole number
            int slope = (int) slope();
            if (slope == 0) {
                return "y = " + (int) yIntercept();
            } else if (slope == 1) {
                return "y = x " + addSub + yintStr;
            } else if (slope == -1) {
                return "y = -x " + addSub + yintStr;
            } else {
                return "y = " + slope + "x " + addSub + yintStr;
            }

        } else {
            double n = slope();
            double firstN = n;
            int d = 1;
            do {

                n += firstN;
                n = roundedToHundredth(n);
                d += 1;


            } while ((n % 1) != 0);

            return "y = " + (int) n + "/" + d + "x " + addSub + yintStr;
        }

    }


    public String coordinateForX(double xValue) {
        double y = (slope() * xValue) + yIntercept();
        return "(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(y) + ")";


    }


    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }


    public String lineInfo() {

        String l1 = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        String l2 = "The equation of the line between these points is: " + equation();
        String l3 = "The slope of this line is: " + slope();
        String l4 = "The y-intercept of the line is: " + yIntercept();
        String l5 = "The distance between the two points is: " + distance();
        return l1 + "\n" + l2 + "\n" + l3 + "\n" + l4 + "\n" + l5 + "\n";
    }
}
