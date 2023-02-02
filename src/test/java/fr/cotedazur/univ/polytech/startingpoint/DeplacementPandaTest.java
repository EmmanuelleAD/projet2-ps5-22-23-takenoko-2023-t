package fr.cotedazur.univ.polytech.startingpoint;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeplacementPandaTest {

        @Test
        public void testGetDescription() {
            Personnage panda = new Personnage("Panda") {
                @Override
                public Optional<Bambou> move(Parcelle parcelle, List<Parcelle> parcelles) {
                    return Optional.empty();
                }
            };
            DeplacementPanda dp = new DeplacementPanda("Player1", panda);
            String expected = "DeplacementPanda by Player1 for Panda";
            assertEquals(expected, dp.getDescription());
        }
    }