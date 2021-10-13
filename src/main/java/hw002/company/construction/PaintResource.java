package hw002.company.construction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaintResource implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(PaintResource.class);

    public void paint() {
        LOGGER.debug("This painted in Green");
    }

    @Override
    public void close() {
        LOGGER.debug("Painting was stopped and closed");
    }
}
