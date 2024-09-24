pacakage StevenAlvaradoCS490.service.impl;

import lombok.AllArgsConstructor;
import StevneAlvaradoCS490.FilmDto;
import StevenAlvaradoCS490.service.FilmService;
import StevenAlvaradoCS490.repository.FilmRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService{

    private FilmRepository filmrepository;

    @Override
    public FilmDto createFilm(FilmDto filmDto){
        return null;
    }
}
