package edu.microserviceslab.usagemicroservice.controller;

import edu.microserviceslab.usagemicroservice.entity.UsageStatistic;
import edu.microserviceslab.usagemicroservice.service.interfaces.UsageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/usage")
public class UsageController {

    private UsageService usageService;

    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<UsageStatistic> listAllUsageStatistics() {
        return usageService.getAllUsageStatistics();
    }

    @ResponseBody
    @RequestMapping("/driver/{driverId}")
    public List<UsageStatistic> listAllUsageStatisticsForDriver(@PathVariable("driverId") Long driverId) {
        return usageService.getUsageStatisticsPerDriver(driverId);
    }

    @ResponseBody
    @RequestMapping("/vehicle/{vehicleId}")
    public List<UsageStatistic> listAllUsageStatisticsForVehicle(@PathVariable("vehicleId") Long vehicleId) {
        return usageService.getUsageStatisticsPerVehicle(vehicleId);
    }

    @ResponseBody
    @RequestMapping(path = "/add" , method = RequestMethod.POST )
    public UsageStatistic addUsage (@RequestBody UsageStatistic temp)
    {
	if(temp == null)
            throw new IllegalStateException("usageStatistic can not be null");
        if(temp.getCreatedDate() == null)
            throw new IllegalStateException("CreateDate can not be null");
        if(temp.getFuelLevel() == null)
            throw new IllegalStateException("FuelLevel can not be null");
        if(temp.getLatitude() == null)
            throw new IllegalStateException("Latitude can not be null");
        if(temp.getLongitude() == null)
            throw new IllegalStateException("longtitude can not be null");
        if(temp.getRotationsPerMinute() == null)
            throw new IllegalStateException("rotationperminute can not be null");
        if(temp.getSpeed() == null)
            throw new IllegalStateException("speed  can not be null");
        if(temp.getVehicleId() == null)
            throw new IllegalStateException("Vehicle id can not be null");

        usageService.addUsageStatistic(temp);
        return temp;
    }
}
