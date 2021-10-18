package Services;

import com.udemy.springpetclinic.Models.Owner;


public interface IOwnerService extends ICRUDService<Owner, Long>{

    Owner findByLastName(String lastName);
}
