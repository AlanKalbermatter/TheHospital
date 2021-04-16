package Models.Building;

import Interfaces.IAmbulance;

import java.util.Objects;

public class Hospital
        implements IAmbulance {

    private String name;
        private String address;

        public static class Builder {

            private String name;

            private String address;
            public Builder withName( String name ){
                this.name = name;

                return this;
            }

            public Builder withAddress( String address ){
                this.address = address;

                return this;
            }

            public Hospital build() {
                Hospital hospital = new Hospital();
                hospital.name = this.name;
                hospital.address = this.address;
                return hospital;
            }


        }
        private Hospital(){}


        public String getName() { return name; }

        public void setName( String name ) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress( String address ) {
            this.address = address;
        }


        @Override
        public boolean equals( Object o ) {
            if ( this == o ) return true;
            if ( !( o instanceof Hospital ) ) return false;
            Hospital hospital = (Hospital) o;
            return getName().equals( hospital.getName() ) && getAddress().equals( hospital.getAddress() );
        }

        @Override
        public int hashCode() {
            return Objects.hash( getName(), getAddress() );
        }

        @Override
        public String toString() {
            return "Hospital{" +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        @Override
        public void transferPatient() {
            System.out.println( "Patient has been transferred" );
        }
}
