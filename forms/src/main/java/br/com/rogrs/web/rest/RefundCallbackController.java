package br.com.rogrs.web.rest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.m4u.gateway.view.dto.RequestResponseDTO;

@RestController
@RequestMapping(value = RefundCallbackController.BASE_URL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class RefundCallbackController {
    public static final String BASE_URL = "/gateway/oitv/callback/v1";
    private static final Logger logger = Logger.getLogger(RefundCallbackController.class);

   

    @RequestMapping(method = RequestMethod.PUT, value = "/service/{serviceId}/transaction/{transactionId}/refund/{refundId}/status/{status}")
    @ResponseBody
    public ResponseEntity<RequestResponseDTO> notificationRefund(@PathVariable("serviceId") final String serviceId,
            @PathVariable("transactionId") final String transactionId, 
            @PathVariable("refundId") final String refundId, 
            @PathVariable("status") final String status) {

        

        logger.info("received a callback from PBM with the values: " +
                "serviceId " + serviceId + " transactionId " + transactionId +
                " refundId " + refundId +
                " status " + status);


        final RequestResponseDTO responseDTO = new RequestResponseDTO();
        responseDTO.setCode("200");
        responseDTO.setDetail("Teste");
        responseDTO.setHttpStatus("200");
        responseDTO.setRef("REF");

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}