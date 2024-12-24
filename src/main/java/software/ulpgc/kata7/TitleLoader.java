package software.ulpgc.kata7;

import java.io.IOException;
import java.util.List;

public interface TitleLoader {
    List<Title> load() throws IOException;
}
