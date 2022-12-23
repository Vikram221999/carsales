/*
 * package com.stg.controller;
 * 
 * import java.lang.reflect.Type; import java.util.List;
 * 
 * import org.apache.catalina.mapper.Mapper; import org.modelmapper.ModelMapper;
 * import org.modelmapper.TypeToken; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.stg.dto.CarDto1; import com.stg.entity.Car; import
 * com.stg.entity.CarAddress; import com.stg.entity.CarStatus; import
 * com.stg.entity.GearTransmission; import com.stg.entity.OwnerType; import
 * com.stg.entity.Premium; import com.stg.entity.StateOfRegistration; import
 * com.stg.entity.User; import com.stg.exception.UserException; import
 * com.stg.service.CarServiceInterface; import
 * com.stg.service.UserServiceInterface;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "car") public class CarController {
 * 
 * 
 * 
 * @Autowired private CarServiceInterface carServiceInterface;
 * 
 * @Autowired private ModelMapper mapper;
 * 
 * @Autowired private UserServiceInterface serviceInterface;
 * 
 * 
 * 
 * @PostMapping(value = "create") public ResponseEntity<Car>
 * createCar(@RequestParam int userId, @RequestParam String carNumber,
 * 
 * @RequestParam String carName, @RequestParam com.stg.entity.FuelType fuelType,
 * 
 * @RequestParam OwnerType ownerType, @RequestParam int
 * yearOfManufacture, @RequestParam String carModelName,
 * 
 * @RequestParam GearTransmission gearTransmission, @RequestParam int
 * kmDriven, @RequestParam int price, String description ,@RequestParam Premium
 * premium, @RequestParam StateOfRegistration registration) throws UserException
 * {
 * 
 * User user = serviceInterface.readById(userId); Car car2 = new Car(price,
 * carNumber, carName, fuelType, ownerType, yearOfManufacture, carModelName,
 * gearTransmission, kmDriven, price, description,premium ,registration); return
 * new ResponseEntity<Car>(carServiceInterface.createCar(car2,userId),
 * HttpStatus.OK);
 * 
 * }
 * 
 * @GetMapping(value = "readAllCar") public List<CarDto1> readAllCar() {
 * List<Car> cars = carServiceInterface.readAllCar(); Type listType = new
 * TypeToken<List<CarDto1>>() { }.getType(); List<CarDto1> carDto1s =
 * mapper.map(cars, listType);
 * 
 * 
 * return carDto1s;
 * 
 * }
 * 
 * @GetMapping(value = "readByCarNumber") public CarDto1
 * readByCarNumber(@RequestParam String carNumber) throws UserException { Car
 * car=carServiceInterface.readByCarNumber(carNumber); CarDto1
 * dto=mapper.map(car, CarDto1.class); return dto; }
 * 
 * @GetMapping(value = "readByCarName") public List<Car>
 * readByCarName(@RequestParam String carName) throws UserException { return
 * carServiceInterface.readByCarName(carName); }
 * 
 * @GetMapping(value = "readByYear") public List<Car> readByYear(@RequestParam
 * int year) throws UserException { return carServiceInterface.readByYear(year);
 * }
 * 
 * @PutMapping(value = "upadateCarStatus") public ResponseEntity<CarDto1>
 * upadateCarStatus(@RequestParam int id, @RequestParam String carNumber,
 * 
 * @RequestParam CarStatus carStatus) throws UserException { Car
 * car=carServiceInterface.upadateCarStatus(id, carNumber, carStatus); CarDto1
 * dto=mapper.map(car, CarDto1.class); return new ResponseEntity<CarDto1>(dto,
 * HttpStatus.OK); }
 * 
 * 
 * @PutMapping(value = "upadateCarName") public ResponseEntity<CarDto1>
 * updateCarName(@RequestParam int id, @RequestParam String carNumber,
 * 
 * @RequestParam String changeName) throws UserException { Car
 * car=carServiceInterface.updateCarName(id, carNumber, changeName); CarDto1
 * dto=mapper.map(car, CarDto1.class); return new ResponseEntity<CarDto1>(dto,
 * HttpStatus.OK);
 * 
 * 
 * }
 * 
 * @PutMapping(value = "upadateYearOfManufacture") public
 * ResponseEntity<CarDto1> updateYearOfManufacture(@RequestParam int
 * id, @RequestParam String carNumber,
 * 
 * @RequestParam int year) throws UserException{ Car
 * car=carServiceInterface.upadateYearOfManufacture(id, carNumber, year);
 * CarDto1 dto=mapper.map(car, CarDto1.class); return new
 * ResponseEntity<CarDto1>(dto, HttpStatus.OK);
 * 
 * }
 * 
 * @PutMapping(value = "upadateCarModel") public ResponseEntity<CarDto1>
 * upadateCarModel(@RequestParam int id, @RequestParam String carNumber,
 * 
 * @RequestParam String carModel)throws UserException { Car
 * car=carServiceInterface.upadateCarModel(id, carNumber, carModel); CarDto1
 * dto=mapper.map(car, CarDto1.class); return new ResponseEntity<CarDto1>(dto,
 * HttpStatus.OK);
 * 
 * }
 * 
 * @PutMapping(value = "upadateOwner") public ResponseEntity<CarDto1>
 * updateOwnerType(@RequestParam int id, @RequestParam String carNumber,
 * 
 * @RequestParam OwnerType ownerType) throws UserException{ Car
 * car=carServiceInterface.updateOwnerType(id, carNumber, ownerType); CarDto1
 * dto=mapper.map(car, CarDto1.class); return new ResponseEntity<CarDto1>(dto,
 * HttpStatus.OK);
 * 
 * 
 * }
 * 
 * @PutMapping(value = "upadateDescription") public ResponseEntity<CarDto1>
 * updateDescription(@RequestParam int id, @RequestParam String carNumber,
 * 
 * @RequestParam String description) throws UserException{ Car
 * car=carServiceInterface.updateDescription(id, carNumber, description);
 * CarDto1 dto=mapper.map(car, CarDto1.class); return new
 * ResponseEntity<CarDto1>(dto, HttpStatus.OK);
 * 
 * 
 * }
 * 
 * // @PutMapping(value = "upadateCarAddressArea") // public ResponseEntity<Car>
 * upadateCarAddressArea(@RequestParam int id, @RequestParam String carNumber,
 * // @RequestParam String area) throws UserException{ // // return new
 * ResponseEntity<Car>(carServiceInterface.updateDescription(id, carNumber,
 * area), HttpStatus.OK); // // } // @PutMapping(value =
 * "upadateCarAddressCity") // public ResponseEntity<Car>
 * upadateCarAddressCity(@RequestParam int id, @RequestParam String carNumber,
 * // @RequestParam String city) throws UserException{ // // return new
 * ResponseEntity<Car>(carServiceInterface.updateDescription(id, carNumber,
 * city), HttpStatus.OK); // // } // @PutMapping(value =
 * "upadateCarAddressState") // public ResponseEntity<Car>
 * upadateCarAddressState(@RequestParam int id, @RequestParam String carNumber,
 * // @RequestParam String state) throws UserException{ // // return new
 * ResponseEntity<Car>(carServiceInterface.updateDescription(id, carNumber,
 * state), HttpStatus.OK); // // }
 * 
 * //@DeleteMapping(value = "deleteCarByCarNumber") // public
 * ResponseEntity<String>deleteCarByCarNumber(@RequestParam int
 * id, @RequestParam String carNumber)throws UserException { // return new
 * ResponseEntity<String>(carServiceInterface.deleteCarByCarNumber(id,
 * carNumber), HttpStatus.OK); // // }
 * 
 * }
 */