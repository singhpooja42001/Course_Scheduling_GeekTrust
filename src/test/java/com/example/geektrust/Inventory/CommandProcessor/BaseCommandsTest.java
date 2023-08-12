package com.example.geektrust.Inventory.CommandProcessor;

import com.example.geektrust.Exception.CommonException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BaseCommandsTest {

    @Test
    public void from() throws CommonException {
        assertThrows(CommonException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                BaseCommands.from(BaseCommands.FIRST.name());
            }
        });
        assertEquals(BaseCommands.FIRST.commands,"ADD-COURSE-OFFERING");
    }
}