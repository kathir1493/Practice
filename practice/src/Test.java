public class Test {

    public static void main(String[] args) {


        System.out.println(FreshworksRegion.STAGING.getUri());
        System.out.println(System.getenv("test"));




    }

    public static enum FreshworksRegion {
        QA("https://accounts.freshid.io"),
        STAGING(System.getenv("test"));


       private String uri;

        private FreshworksRegion(String uri) {
            this.uri = uri;
        }

        public String getUri() {
            return this.uri;
        }


    }
    }

