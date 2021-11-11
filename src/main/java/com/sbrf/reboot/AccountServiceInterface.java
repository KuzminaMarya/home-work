package com.sbrf.reboot;

import java.util.Set;

public interface AccountServiceInterface {
    Set<Account> getAllAccountsByClientId(long clientId);
}
