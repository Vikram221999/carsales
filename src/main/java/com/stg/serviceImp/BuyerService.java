package com.stg.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.dto.CarDto1;
import com.stg.entity.Address;
import com.stg.entity.Advertisement;
import com.stg.entity.Bookings;
import com.stg.entity.Bookings.Choose;
import com.stg.entity.Car;
import com.stg.entity.FuelType;
import com.stg.entity.OwnerType;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.repository.AddressRepo;
import com.stg.repository.CarRepo;
import com.stg.repository.UserRepo;
import com.stg.service.BuyerServiceInterface;

import net.bytebuddy.description.modifier.Ownership;

@Service
public class BuyerService implements BuyerServiceInterface {

	@Autowired
	private CarRepo carRepo;
	@Autowired
	private CarServiceImpl carService;
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public List<Car> searchByCity(String city) throws UserException {
		if (city != null) {
			List<User> users = new ArrayList<>();
			List<Advertisement> advertisements = new ArrayList<Advertisement>();
			List<Car> cars = new ArrayList<>();
			List<Address> addresses = addressRepo.findAll();
			for (Address address : addresses) {
				if (address.getCity().equalsIgnoreCase(city)) {
					users.add(address.getUser());
				}
			}
			for (User user : users) {
				advertisements = user.getAdvertisements();
				for (Advertisement advertisement : advertisements) {
					cars.add(advertisement.getCar());

				}
			}
			if (cars.size() > 0) {
				return cars;
			} else {
				throw new UserException("No city is found");
			}
		} else {
			throw new UserException("You Enter the Incorrect City");
		}
	}

	@Override
	public List<Car> serchByCityYearBrand(String city, String brandName, int year) throws UserException {
		if (city != null) {
			List<User> users = new ArrayList<>();
			List<Advertisement> advertisements = new ArrayList<Advertisement>();
			List<Car> cars = new ArrayList<>();
			List<Address> addresses = addressRepo.findAll();
			for (Address address : addresses) {
				if (address.getCity().equalsIgnoreCase(city)) {
					users.add(address.getUser());
				}
			}
			for (User user : users) {
				advertisements = user.getAdvertisements();
				for (Advertisement advertisement : advertisements) {
					Car car = advertisement.getCar();
					if (car.getCarName().equalsIgnoreCase(brandName) && car.getYearOfManufacture() == year)
						cars.add(advertisement.getCar());

				}
			}
			if (cars.size() > 0) {
				return cars;
			} else {
				throw new UserException("No city is found");
			}
		} else {
			throw new UserException("You Enter the Incorrect City");
		}
	}

	@Override
	public List<Car> serchByCityBrandNameFuelType(String city, String brandName, FuelType fuelType)
			throws UserException {
		if (city != null) {
			List<User> users = new ArrayList<>();
			List<Advertisement> advertisements = new ArrayList<Advertisement>();
			List<Car> cars = new ArrayList<>();
			List<Address> addresses = addressRepo.findAll();
			for (Address address : addresses) {
				if (address.getCity().equalsIgnoreCase(city)) {
					users.add(address.getUser());
				}
			}
			for (User user : users) {
				advertisements = user.getAdvertisements();
				for (Advertisement advertisement : advertisements) {
					
					List<Bookings> bookings = advertisement.getBooking();
					if (bookings.isEmpty()) {
						Car car = advertisement.getCar();
						if (car.getCarName().equalsIgnoreCase(brandName) && car.getFuelType() == fuelType)
							cars.add(advertisement.getCar());
					}
					for (Bookings booking : bookings) {
						if (booking.getChoose() != Choose.ACCEPT) {
							Car car = advertisement.getCar();
							if (car.getCarName().equalsIgnoreCase(brandName) && car.getFuelType() == fuelType)
								cars.add(advertisement.getCar());
						}

					}

				}
			}
			if (cars.size() > 0) {
				return cars;
			} else {
				throw new UserException("No city is found");
			}
		} else {
			throw new UserException("You Enter the Incorrect City");
		}
	}

	@Override
	public List<Car> serchByCityBrandNameOwner(String city, String brandName, OwnerType ownerType)
			throws UserException {

		if (city != null) {
			List<User> users = new ArrayList<>();
			List<Advertisement> advertisements = new ArrayList<Advertisement>();
			List<Car> cars = new ArrayList<>();
			List<Address> addresses = addressRepo.findAll();
			for (Address address : addresses) {
				if (address.getCity().equalsIgnoreCase(city)) {
					users.add(address.getUser());
				}
			}
			for (User user : users) {
				advertisements = user.getAdvertisements();
				for (Advertisement advertisement : advertisements) {
					List<Bookings> bookings = advertisement.getBooking();
					if (bookings.isEmpty()) {
						Car car = advertisement.getCar();
						if (car.getCarName().equalsIgnoreCase(brandName) && car.getOwnerType() == ownerType)
							cars.add(advertisement.getCar());
					}
					for (Bookings booking : bookings) {
						if (booking.getChoose() != Choose.ACCEPT) {
							Car car = advertisement.getCar();
							if (car.getCarName().equalsIgnoreCase(brandName) && car.getOwnerType() == ownerType)
								cars.add(advertisement.getCar());
						}

					}

				}
			}
			if (cars.size() > 0) {
				return cars;
			} else {
				throw new UserException("No city is found");
			}
		} else {
			throw new UserException("You Enter the Incorrect City");
		}
	}

	@Override
	public List<CarDto1> serchByFuelType(FuelType fuelType) throws UserException {
		
		
		
		
		
		List<CarDto1> list = carService.readAllCar();
				//carRepo.findAllCar();
		List<CarDto1> cars = new ArrayList<>();
		if (fuelType != null) {
			for (CarDto1 car : list) {
				if (car.getFuelType() == fuelType) {
					cars.add(car);
				}
			}
			return cars;
		} else {
			throw new UserException("Opps....No Car found");
		}
	}

	@Override
	public List<CarDto1> serchByPrice(int price) throws UserException {

		List<CarDto1> list = carService.readAllCar();
		List<CarDto1> cars = new ArrayList<>();
		if (price > 0) {
			for (CarDto1 car : list) {
				if (car.getPrice() >= price) {
					cars.add(car);
				}
			}
			return cars;
		} else {
			throw new UserException("Opps....No Car found");
		}
	}

	@Override
	public List<CarDto1> serchByOwnerType(OwnerType ownerType) throws UserException {
		List<CarDto1> list =carService.readAllCar();
		List<CarDto1> cars = new ArrayList<>();
		if (ownerType != null) {
			for (CarDto1 car : list) {
				if (car.getOwnerType() == ownerType) {
					cars.add(car);
				}
			}
			return cars;
		} else {
			throw new UserException("Opps....No Car found");
		}
	}
}
