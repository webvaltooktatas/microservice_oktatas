package hu.webvalto.repository;

import hu.webvalto.domain.Ceg;
import hu.webvalto.domain.Maganember;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AdozoRepository {
    private Map<Integer, Maganember> maganemberMap = new HashMap<>();
    private Map<Integer, Ceg> cegMap = new HashMap<>();

    public Map<Integer, Maganember> getMaganemberMap() {
        return maganemberMap;
    }

    public Map<Integer, Ceg> getCegMap() {
        return cegMap;
    }

    public Maganember getMaganemberById(Integer id) {
        return maganemberMap.get(id);
    }

    public Ceg getCegById(Integer id) {
        return cegMap.get(id);
    }

    public void addUjMaganember(Maganember maganember) {
        maganemberMap.put(maganemberMap.size() + 1, maganember);
    }

    public void addUjCeg(Ceg ceg) {
        cegMap.put(cegMap.size() + 1, ceg);
    }

    public void modifyMaganember(Integer id, Maganember maganember) {
        maganemberMap.put(id, maganember);
    }

    public void modifyCeg(Integer id, Ceg ceg) {
        cegMap.put(id, ceg);
    }

    public void removeMaganember(Integer id) {
        maganemberMap.remove(id);
    }

    public void removeCeg(Integer id) {
        cegMap.remove(id);
    }
}
