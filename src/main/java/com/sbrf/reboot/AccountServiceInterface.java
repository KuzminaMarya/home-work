package com.sbrf.reboot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface AccountServiceInterface {
    Set<Account> getAllAccountsByClientId(long clientId) throws IOException;
}
