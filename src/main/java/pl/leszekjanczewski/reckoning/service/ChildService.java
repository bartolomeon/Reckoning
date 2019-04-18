package pl.leszekjanczewski.reckoning.service;

import pl.leszekjanczewski.reckoning.model.Child;


//TODO: zastanów się nad granicami dla transakcji - możliwe, że sensownie byłoby zrobić ją na warstwie Service -> adnotacja @Transactional
//TODO: stwórz klasę bazową albo marker interface dla klas podobnego typu (np. Service)
public interface ChildService { //TODO: interfejsy można... ale to przerost formy nad treścią w przypadku Service...
    Child saveChild(Child child);
}
