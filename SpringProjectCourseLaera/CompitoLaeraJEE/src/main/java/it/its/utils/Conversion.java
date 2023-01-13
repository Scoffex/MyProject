package it.its.utils;
import java.util.ArrayList;
import java.util.List;
import it.its.DTO.AereoDTO;
import it.its.DTO.ProduttoreDTO;
import it.its.DTO.TrattaDTO;
import it.its.domain.Aereo;
import it.its.domain.AereoTratta;
import it.its.domain.Produttore;
import it.its.domain.Tratta;




public class Conversion {

	public static AereoDTO fromAereoDTOToDomain (Aereo aereo) {
		AereoDTO aereoDTO = new AereoDTO();
		aereoDTO.setAnnoDiProduzione(aereo.getAnnoDiProduzione());
		aereoDTO.setCapienza(aereo.getCapienza());
		aereoDTO.setId(aereo.getId());
		aereoDTO.setModello(aereo.getModello());
		aereoDTO.setNome(aereo.getNome());
		aereoDTO.setTarga(aereo.getTarga());
		aereoDTO.setIdProduttore(aereo.getProduttore().getId());
		return aereoDTO;
		
	}
	public static Aereo fromAereoToAereoDTO(AereoDTO aereoDTO) {
		Aereo aereo = new Aereo();
		aereo.setAnnoDiProduzione(aereoDTO.getAnnoDiProduzione());
		aereo.setCapienza(aereoDTO.getCapienza());
		aereo.setModello(aereoDTO.getModello());
		aereo.setNome(aereoDTO.getNome());
		aereo.setTarga(aereoDTO.getTarga());
		aereo.setId(aereoDTO.getId());
		return aereo;
	}
	
	public static List<AereoDTO> aereoDTOListFromAereoList (List<Aereo> aereoList){
		List<AereoDTO> aereoDTOList  = new ArrayList<AereoDTO>();
		for (Aereo aereo : aereoList) {
			AereoDTO aereoDTO = fromAereoDTOToDomain(aereo);
			aereoDTOList.add(aereoDTO);
		}
		return aereoDTOList;
	}
	public static ProduttoreDTO fromProduttoreDTOtoProduttore (Produttore produttore) {
		ProduttoreDTO produttoreDTO = new ProduttoreDTO();
		produttoreDTO.setId(produttore.getId());
		produttoreDTO.setNazione(produttore.getNazione());
		produttoreDTO.setNome(produttore.getNome());
		produttoreDTO.setSedeLegale(produttore.getSedeLegale());
		return produttoreDTO;
	}
	public static Produttore fromProduttoreToProduttoreDTO(ProduttoreDTO produttoreDTO) {
		Produttore produttore = new Produttore();
		produttore.setId(produttoreDTO.getId());
		produttore.setNazione(produttoreDTO.getNazione());
		produttore.setNome(produttoreDTO.getNome());
		produttore.setSedeLegale(produttoreDTO.getSedeLegale());
		produttore.setAereo(null);
		
		return produttore;
		
	}
	public static List<ProduttoreDTO> produttoreDTOListFromProduttore (List<Produttore> produttoreList){
		List<ProduttoreDTO> produttoreDTOList  = new ArrayList<ProduttoreDTO>();
		for (Produttore produttore : produttoreList) {
			ProduttoreDTO produttoreDTO = fromProduttoreDTOtoProduttore(produttore);
			produttoreDTOList.add(produttoreDTO);
		}
		return produttoreDTOList;
}
	public static TrattaDTO fromTrattaDTOtoTratta(Tratta tratta) {
		TrattaDTO trattaDTO = new TrattaDTO();
		trattaDTO.setAereoportoArrivo(tratta.getAereoportoArrivo());
		trattaDTO.setAereoportoPartenza(tratta.getAereoportoPartenza());
		trattaDTO.setId(tratta.getId());
		List<Integer> idAereo = new ArrayList<Integer>();
		for(AereoTratta aereoTratta : tratta.getAereoTratta()) {
			idAereo.add(aereoTratta.getAereo().getId());
		}
		trattaDTO.setIdAereo(idAereo);
		return trattaDTO;
	}
	public static Tratta formTrattaToTrattaDTO(TrattaDTO trattaDTO) {
		Tratta tratta = new Tratta();
		tratta.setAereoportoArrivo(trattaDTO.getAereoportoArrivo());
		tratta.setAereoportoPartenza(trattaDTO.getAereoportoPartenza());
		tratta.setId(trattaDTO.getId());
		tratta.setKmPercorsi(trattaDTO.getKmPercorsi());
		return tratta;
	}
	public static List<TrattaDTO> trattaDTOListFromTrattaList (List<Tratta> trattaList){
		List<TrattaDTO> trattaListDTO  = new ArrayList<TrattaDTO>();
		for (Tratta tratta : trattaList) {
			TrattaDTO trattaDTO = fromTrattaDTOtoTratta(tratta);
			trattaListDTO.add(trattaDTO);
		}
		return trattaListDTO;
}
}
