package com.sbrf.reboot.atm.cassettes;

import com.sbrf.reboot.Banknote;
import com.sbrf.reboot.Cassette;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CassetteTest {

    class OneHundred extends Banknote {
    }

    class OneThousand extends Banknote {
    }

    @Test
    void getCountBanknotes() {
        OneHundred oneHundred = new OneHundred();

        Cassette<Banknote> cassette = new Cassette<>(new ArrayList<Banknote>() {{
            add(oneHundred);
            add(new OneThousand());
            add(new Banknote());
        }});

        Assertions.assertEquals(3, cassette.getCountBanknotes());
    }
}