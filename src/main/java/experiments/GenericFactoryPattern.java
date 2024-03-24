package experiments;

import lombok.Getter;

public class GenericFactoryPattern {

    static class CarrierRequest{
        int a;
        int b;
    }

    @Getter
    static class ERRequest extends CarrierRequest {
         int c;
    }

    static class FERequest  {
        int d;
    }

    public static void main(String[] args) {
        CarrierRequest carrierRequest = new ERRequest();
        carrierRequest.a = 1;
        carrierRequest.b = 2;

        ERRequest erRequest = (ERRequest) carrierRequest;

        erRequest.c = 2;
        erRequest.a = 2;

        System.out.println("carrierRequest.a :: " + carrierRequest.a);

    }
}
