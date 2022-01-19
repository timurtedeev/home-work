package com.sbrf.reboot.homework5;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Region<T extends City> {
    String regionName;
    ArrayList<City> cities;
}
