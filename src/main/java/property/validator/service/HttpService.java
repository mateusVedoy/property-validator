package property.validator.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.validation.constraints.Future;
import property.validator.useCase.SetRandomResponse;

@Dependent
public class HttpService {

    @Inject
    SetRandomResponse validator;
    @Inject
    @RestClient
    IHttp http;

    public void response(Long propId) {
        sleep();//isso não está deixando processo async
        String resp = validator.set();
        http.post(propId, resp);//aqui gera erro que não consegui resolver
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
