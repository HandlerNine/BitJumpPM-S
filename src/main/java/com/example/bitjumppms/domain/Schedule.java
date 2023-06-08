package com.example.bitjumppms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Schedule {
    ArrayList<String> names;
    String endTime;
}
