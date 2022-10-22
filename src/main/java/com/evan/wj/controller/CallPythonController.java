package com.evan.wj.controller;

import com.evan.wj.service.CallPythonService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class CallPythonController {

    private final CallPythonService callPythonService;

    public CallPythonController(CallPythonService callPythonService) {
        this.callPythonService = callPythonService;
    }

    @GetMapping("/api/ins/funs")
    @ResponseBody
    public Object callPython(@RequestParam("name") String name, @RequestParam("count") int count) throws IOException {
        System.out.println("name:" + name + ", count:" + count);
        return callPythonService.getByNameAndCount(name, count);
    }
}
