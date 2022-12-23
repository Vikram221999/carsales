/*
 * package com.stg.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * com.stg.dto.AddressDto; import com.stg.entity.Address; import
 * com.stg.entity.User; import com.stg.exception.UserException; import
 * com.stg.service.AddressServiceInterface; import
 * com.stg.service.UserServiceInterface;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "address") public class AddressController {
 * 
 * 
 * @Autowired private AddressServiceInterface addressServiceInterface;
 * 
 * @PostMapping(value = "create") public ResponseEntity<Address>
 * createAddress(@RequestBody AddressDto addDto) throws UserException {
 * 
 * return new
 * ResponseEntity<Address>(addressServiceInterface.createAddress(addDto),
 * HttpStatus.OK);
 * 
 * }
 * 
 * @GetMapping(value = "readAllAddress") public List<Address> readAllAddress() {
 * 
 * return addressServiceInterface.readAllAddress();
 * 
 * }
 * 
 * @GetMapping(value = "readByCity") public List<Address>
 * readByCity(@RequestParam String city) throws UserException { return
 * addressServiceInterface.readByCity(city); }
 * 
 * @GetMapping(value = "readByState") public List<Address>
 * readByState(@RequestParam String state) throws UserException { return
 * addressServiceInterface.readByState(state); }
 * 
 * @PutMapping(value = "updateDoorNumber") public ResponseEntity<Address>
 * updateDoorNumber(@RequestParam int id, @RequestParam int doorNo) throws
 * UserException { return new
 * ResponseEntity<Address>(addressServiceInterface.updateDoorNumber(id, doorNo),
 * HttpStatus.OK);
 * 
 * }
 * 
 * @PutMapping(value = "updateStreetName") public ResponseEntity<Address>
 * updateStreetName(@RequestParam int id,@RequestParam String streetName) throws
 * UserException { return new
 * ResponseEntity<Address>(addressServiceInterface.updateStreetName(id,
 * streetName), HttpStatus.OK);
 * 
 * }
 * 
 * @PutMapping(value = "updateCity") public ResponseEntity<Address>
 * updateCity(@RequestParam int id, @RequestParam String city) throws
 * UserException { return new
 * ResponseEntity<Address>(addressServiceInterface.updateCity(id, city),
 * HttpStatus.OK);
 * 
 * }
 * 
 * @PutMapping(value = "updateState") public ResponseEntity<Address>
 * updateState(@RequestParam int id, @RequestParam String state) throws
 * UserException { return new
 * ResponseEntity<Address>(addressServiceInterface.updateState(id, state),
 * HttpStatus.OK);
 * 
 * }
 * 
 * 
 * 
 * }
 */