package com.goriant.sharing;

import static com.goriant.sharing.ErrorMessage.ERROR_MSG_FILE_INPUT_PATH_REQUIRED;

import com.goriant.sharing.exception.APIException;
import com.goriant.sharing.packer.Packer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lam Le - lamle@gmx.com
 */
@Slf4j
public class Application {

    public static void main(String[] args) throws APIException {

        //guard
        if (args.length != 1) throw new APIException(ERROR_MSG_FILE_INPUT_PATH_REQUIRED);

        long start = System.currentTimeMillis();

        final String pack = Packer.pack(args[0]);
        log.info("Result : {}", pack);

        long end = System.currentTimeMillis();
        log.info("Packer pack duration : {}", (end - start));
    }
}
