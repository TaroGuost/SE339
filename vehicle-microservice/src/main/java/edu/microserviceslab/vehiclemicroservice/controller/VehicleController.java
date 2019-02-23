package edu.microserviceslab.vehiclemicroservice.controller;

import edu.microserviceslab.vehiclemicroservice.entity.Vehicle;
import edu.microserviceslab.vehiclemicroservice.service.interfaces.VehicleService;
import org.hibernate.annotations.CascadeType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToOne;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Vehicle> listAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @ResponseBody
    @RequestMapping("/licensePlate/{vehicleId}")
    public String getVehicleLicensePlate(@PathVariable("vehicleId") Long vehicleId) {
        return vehicleService.getVehicleLicensePlate(vehicleId);
    }

    @ResponseBody
    @RequestMapping( path = "/add" , method = RequestMethod.POST)
    public Vehicle addVehicle(@RequestBody Vehicle v)
    {
        if(v == null)
            throw new IllegalStateException("Vehicle can not be null");
        if(v.getMake() == null)
            throw new IllegalStateException("make can not be null");
        if(v.getModel() == null)
            throw new IllegalStateException("Model can not be null");
        if(v.getModelYear() == null)
            throw new IllegalStateException("ModelYear can not be null");
        if(v.getRegistration() == null)
            throw new IllegalStateException("Registration can not be null");
        if(v.getRegistration().getLicensedTo() == null)
            throw new IllegalStateException("getLicensedTO can not be null");
        if(v.getRegistration().getLicensePlate() == null)
            throw new IllegalStateException("getLicensePlate can not be null");

        System.out.println(v.getModel());
        vehicleService.addVehicleTO(v);
        return v;
    }

    @ResponseBody
    @RequestMapping("/delete/NUll")
    public String deleteNull ()
    {
        vehicleService.deleteNullValue();
        return "data Deleted";
    }

}
