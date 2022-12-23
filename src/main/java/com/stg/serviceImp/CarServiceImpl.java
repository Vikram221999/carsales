package com.stg.serviceImp;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.dto.CarBooking;
import com.stg.dto.CarDto1;
import com.stg.dto.MybookingDto;
import com.stg.entity.Advertisement;
import com.stg.entity.Bookings;
import com.stg.entity.Bookings.Choose;
import com.stg.entity.Car;
import com.stg.entity.CarAddress;
import com.stg.entity.CarStatus;
import com.stg.entity.OwnerType;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.repository.AdvertisementRepo;
import com.stg.repository.BookingRepo;
import com.stg.repository.CarRepo;
import com.stg.repository.UserRepo;
import com.stg.service.CarServiceInterface;
import com.stg.service.UserServiceInterface;

@Service
public class CarServiceImpl implements CarServiceInterface {

	@Autowired
	private CarRepo carRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	private AdvertisementRepo advertisementRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Car createCar(Car car, int userId) throws UserException {
		if (car != null) {
			if (carRepo.existsByCarNumber(car.getCarNumber())) {
				throw new UserException("Car Details is already Exist");
			}
			if (car.getYearOfManufacture() <= (Year.now().getValue() - 15)) {
				throw new UserException("Due to over Life time of Your car, Your Car is not Eligible");
			}
			if (car.getKmDriven() > 150000) {
				throw new UserException("Due to High Km, Your Car is not Eligible");
			}
			if (car.getDescription().length() == 0) {
				throw new UserException("Due to High Km, Your Car is not Eligible");
			}
			carRepo.save(car);

			Car car2 = carRepo.findByCarNumber(car.getCarNumber());
			car2.setCarStatus(CarStatus.Active);

			User user = userRepo.findById(userId).get();
			List<Car> cars = new ArrayList<>();
			cars.add(car2);

			Advertisement advertisement = new Advertisement();
			advertisement.setCar(cars);
			advertisement.setUser(user);

			advertisement.setCarId(car2.getCarId());

			advertisementRepo.save(advertisement);

			car2.setAdvertisement(advertisement);

			car2.setAdvertisement(advertisement);
			carRepo.save(car2);

			return car2;

		} else {
			throw new UserException("Enter the correct Car Details");
		}
	}

	@Override
	public Car readByCarId(int carId) throws UserException {
		Car car = null;
		if (carRepo.existsById(carId)) {
			car = carRepo.findById(carId).get();
			return car;
		} else {
			throw new UserException("Car is not Exist");
		}
	}

	@Override
	public List<CarBooking> readAllCar() {
		List<Car> cars = carRepo.findAllCar();
		List<CarBooking> dtos=new ArrayList<CarBooking>();
		for (Car car : cars) {
			
			CarBooking dto = mapper.map(car, CarBooking.class);
			
			dto.setAdId(car.getAdvertisement().getAdId());
			dto.setUserId(car.getAdvertisement().getUser().getUserId());
			dto.setMobileNumber(car.getAdvertisement().getUser().getMobileNumber());
			dto.setUserName(car.getAdvertisement().getUser().getUserName());
			dto.setStreetName(car.getAdvertisement().getUser().getAddress().getStreetName());
			dto.setDoorNo(car.getAdvertisement().getUser().getAddress().getDoorNo());
			dto.setState(car.getAdvertisement().getUser().getAddress().getState());
			dto.setCity(car.getAdvertisement().getUser().getAddress().getCity());
			dto.setState(car.getAdvertisement().getUser().getAddress().getState());
			dto.setPincode(car.getAdvertisement().getUser().getAddress().getPincode());
			
			dtos.add(dto);
			
		}
		
		
		
		
//	 	List<CarDto1> list=new ArrayList<>();
//	 	for (Car car : cars) {
//			//List<Bookings> bookings= car.getAdvertisement().getBooking();
//
//			if(car.getAdvertisement().getBooking().isEmpty()) {
//				CarDto1 dto=mapper.map(car, CarDto1.class);
//				dto.setAddId(car.getAdvertisement().getAdId());
//				dto.setUserId(car.getAdvertisement().getUser().getUserId());
//				list.add(dto);
//				
//			}
//			for (Bookings bookings2 : car.getAdvertisement().getBooking()) {
//				
//				if (bookings2.getChoose() == Choose.REJECT  || bookings2.getChoose()==Choose.AVAILABLE ) {
//					CarDto1 dto=mapper.map(car, CarDto1.class);
//					dto.setAddId(car.getAdvertisement().getAdId());
//					dto.setUserId(car.getAdvertisement().getUser().getUserId());
//					list.add(dto);
//				}
//			}
//		
//	 	
//	 	}
//	 	
		return dtos;

	}

	@Override
	public CarBooking readByCarNumber(String carNumber) throws UserException {
		Car car = null;
		
		if (carRepo.existsByCarNumber(carNumber)) {
			car = carRepo.findByCarNumber(carNumber);
			
			CarBooking dto = mapper.map(car, CarBooking.class);
			
			dto.setAdId(car.getAdvertisement().getAdId());
			dto.setUserId(car.getAdvertisement().getUser().getUserId());
			dto.setMobileNumber(car.getAdvertisement().getUser().getMobileNumber());
			dto.setUserName(car.getAdvertisement().getUser().getUserName());
			dto.setStreetName(car.getAdvertisement().getUser().getAddress().getStreetName());
			dto.setDoorNo(car.getAdvertisement().getUser().getAddress().getDoorNo());
			dto.setState(car.getAdvertisement().getUser().getAddress().getState());
			dto.setCity(car.getAdvertisement().getUser().getAddress().getCity());
			dto.setState(car.getAdvertisement().getUser().getAddress().getState());
			dto.setPincode(car.getAdvertisement().getUser().getAddress().getPincode());
			
			
			
			return dto;
		} else {
			throw new UserException("Car is not Exist");
		}
	}

//	public Car  readByCarId(int carId)throws UserException{
//		Car car = null;
//		if (carRepo.existsById(carId)) {
//			car = carRepo.findById(carId).get();
//			return car;
//		} else {
//			throw new UserException("Car is not Exist");
//		}
//		
//	}

	@Override
	public List<CarDto1> readByCarName(String carName) throws UserException {
		List<CarDto1> list = new ArrayList<>();
		if (carRepo.existsByCarName(carName)) {
			list = this.readAllCar();
			// list = carRepo.findAllCar();
			for (CarDto1 car : list) {
				if (car.getCarName().equalsIgnoreCase(carName)) {
					list.add(car);
				}
			}
			return list;
		} else {
			throw new UserException("Oops !...No such Car Brand is Avilable ");
		}
	}

	@Override
	public List<CarDto1> readByYear(int year) throws UserException {
		List<CarDto1> list = new ArrayList<>();
		if (carRepo.existsByYearOfManufacture(year)) {
			list = this.readAllCar();
			for (CarDto1 car : list) {
				if (car.getYearOfManufacture() == year) {
					list.add(car);
				}
			}
		} else {
			throw new UserException("Oops !...No such Year of Car is Avilable ");
		}
		return list;

	}

	@Override
	public Car upadateCarStatus(int id, String CarNumber, CarStatus carStatus) throws UserException {
		Car car = null;
		List<Advertisement> advertisements = advertisementRepo.findAll();
		List<User> list = new ArrayList<>();
		for (Advertisement advertisement : advertisements) {
			if (advertisement.getUser().getUserId() == id) {
				list.add(advertisement.getUser());
			}

		}
		if (userRepo.existsById(id)) {

			for (User user : list) {
				List<Advertisement> advertisement = user.getAdvertisements();
				for (Advertisement advertisement1 : advertisement) {
					if (advertisement1.getCar().getCarNumber().equalsIgnoreCase(CarNumber)) {
						car = advertisement1.getCar();
						break;
					}
				}

			}
			if (car != null) {
				car.setCarStatus(carStatus);
				carRepo.save(car);
				return car;
			} else {
				throw new UserException("You Enter the Incorrect Car Number");
			}
		} else {
			throw new UserException("No such UserId is found.");
		}
	}

	@Override
	public Car updateCarName(int id, String CarNumber, String changeName) throws UserException {

		Car car = null;
		List<Advertisement> advertisements = advertisementRepo.findAll();
		List<User> list = new ArrayList<>();
		for (Advertisement advertisement : advertisements) {
			if (advertisement.getUser().getUserId() == id) {
				list.add(advertisement.getUser());
			}

		}
		if (userRepo.existsById(id)) {

			for (User user : list) {
				List<Advertisement> advertisement = user.getAdvertisements();
				for (Advertisement advertisement1 : advertisement) {
					if (advertisement1.getCar().getCarNumber().equalsIgnoreCase(CarNumber)) {
						car = advertisement1.getCar();
						break;
					}
				}

			}
			if (car != null) {
				car.setCarName(changeName);
				carRepo.save(car);
				return car;
			} else {
				throw new UserException("You Enter the Incorrect Car Number");
			}
		} else {
			throw new UserException("No such UserId is found.");
		}
	}

	@Override
	public Car upadateYearOfManufacture(int id, String CarNumber, int year) throws UserException {
		Car car = null;
		List<Advertisement> advertisements = advertisementRepo.findAll();
		List<User> list = new ArrayList<>();
		for (Advertisement advertisement : advertisements) {
			if (advertisement.getUser().getUserId() == id) {
				list.add(advertisement.getUser());
			}

		}
		if (userRepo.existsById(id)) {

			for (User user : list) {
				List<Advertisement> advertisement = user.getAdvertisements();
				for (Advertisement advertisement1 : advertisement) {
					if (advertisement1.getCar().getCarNumber().equalsIgnoreCase(CarNumber)) {
						car = advertisement1.getCar();
						break;
					}
				}

			}
			if (car != null) {
				car.setYearOfManufacture(year);
				carRepo.save(car);
				return car;
			} else {
				throw new UserException("You Enter the Incorrect Car Number");
			}
		} else {
			throw new UserException("No such UserId is found.");
		}
	}

	@Override
	public Car upadateCarModel(int id, String CarNumber, String changeModelName) throws UserException {
		Car car = null;
		List<Advertisement> advertisements = advertisementRepo.findAll();
		List<User> list = new ArrayList<>();
		for (Advertisement advertisement : advertisements) {
			if (advertisement.getUser().getUserId() == id) {
				list.add(advertisement.getUser());
			}

		}
		if (userRepo.existsById(id)) {
			for (User user : list) {
				List<Advertisement> advertisement = user.getAdvertisements();
				for (Advertisement advertisement1 : advertisement) {
					if (advertisement1.getCar().getCarNumber().equalsIgnoreCase(CarNumber)) {
						car = advertisement1.getCar();
						break;
					}
				}

			}
			if (car != null) {
				car.setCarModelName(changeModelName);
				carRepo.save(car);
				return car;
			} else {
				throw new UserException("You Enter the Incorrect Car Number");
			}
		} else {
			throw new UserException("No such UserId is found.");
		}
	}

	@Override
	public Car updateOwnerType(int id, String CarNumber, OwnerType ownerType) throws UserException {
		Car car = null;
		List<Advertisement> advertisements = advertisementRepo.findAll();
		List<User> list = new ArrayList<>();
		for (Advertisement advertisement : advertisements) {
			if (advertisement.getUser().getUserId() == id) {
				list.add(advertisement.getUser());
			}

		}
		if (userRepo.existsById(id)) {

			for (User user : list) {
				List<Advertisement> advertisement = user.getAdvertisements();
				for (Advertisement advertisement1 : advertisement) {
					if (advertisement1.getCar().getCarNumber().equalsIgnoreCase(CarNumber)) {
						car = advertisement1.getCar();
						break;
					}
				}

			}
			if (car != null) {
				car.setOwnerType(ownerType);
				carRepo.save(car);
				return car;
			} else {
				throw new UserException("You Enter the Incorrect Car Number");
			}
		} else {
			throw new UserException("No such UserId is found.");
		}
	}

	@Override
	public Car updateDescription(int id, String CarNumber, String description) throws UserException {
		Car car = null;
		List<Advertisement> advertisements = advertisementRepo.findAll();
		List<User> list = new ArrayList<>();
		for (Advertisement advertisement : advertisements) {
			if (advertisement.getUser().getUserId() == id) {
				list.add(advertisement.getUser());
			}

		}
		if (userRepo.existsById(id)) {
			for (User user : list) {
				List<Advertisement> advertisement = user.getAdvertisements();
				for (Advertisement advertisement1 : advertisement) {
					if (advertisement1.getCar().getCarNumber().equalsIgnoreCase(CarNumber)) {
						car = advertisement1.getCar();
						break;
					}
				}

			}
			if (car != null) {
				car.setDescription(description);
				carRepo.save(car);
				return car;
			} else {
				throw new UserException("You Enter the Incorrect Car Number");
			}
		} else {
			throw new UserException("No such UserId is found.");
		}
	}

	@Override
	public int advertisementId(String carNumber) {
		List<Car> cars = carRepo.findAllCar();
		int adId = 0;
		for (Car car : cars) {
			if (car.getCarNumber().equalsIgnoreCase(carNumber)) {
				adId = car.getAdvertisement().getAdId();
			}
		}
		return adId;
	}

	@Override
	public Advertisement advertisementIdByCarNumber(String carNumber) {
		List<Car> cars = carRepo.findAllCar();
		Advertisement advertisement = null;
		for (Car car : cars) {
			if (car.getCarNumber().equalsIgnoreCase(carNumber)) {
				advertisement = car.getAdvertisement();
			}
		}
		return advertisement;
	}

	@Override
	public Advertisement advertisementIdBycarId(int adId) {
		List<Car> cars = carRepo.findAllCar();
		Advertisement advertisement = null;
		for (Car car : cars) {
			if (car.getCarId() == adId) {
				advertisement = car.getAdvertisement();
			}
		}
		return advertisement;
	}

//	@Override
//	public String deleteCarByCarNumber(int id, String CarNumber) throws UserException {
//		Car car = null;
//		if (userRepo.existsById(id)) {
//
//			Optional<User> optional = userRepo.findById(id);
//			User user1 = optional.get();
//			for (Car car1 : user1.getCars()) {
//				if (car1.getCarNumber().equalsIgnoreCase(CarNumber)) {
//					car = car1;
//					break;
//				}
//			}
//			if (car != null) {
//			//Car car3=null;
//				carRepo.deleteById(car.getCarId());
//				//carRepo.save(car3);
//				return "Car Details Deleted.";
//			} else {
//				throw new UserException("You Enter the Incorrect Car Number");
//			}
//		} else {
//			throw new UserException("No such UserId is found.");
//		}
//	
//		
//	}

}
