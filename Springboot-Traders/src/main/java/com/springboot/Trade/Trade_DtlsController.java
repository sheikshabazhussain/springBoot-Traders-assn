package com.springboot.Trade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Trade_DtlsController
{
	@Autowired
 Trade_DtlsRepo traderepo;
	
	

    @GetMapping("/gettrades")
    public List<Trade_Dtls> getAllTrade_Dtls()
    {
        return (List<Trade_Dtls>) traderepo.findAll();
    }
    
    
    @PostMapping("/savetraders")
    public Trade_Dtls addtrade(@RequestBody Trade_Dtls traders) 
    {
        return traderepo.save(traders);
    }
    
    

    
    @PutMapping("/updateTrade")
	public Trade_Dtls updateTrade(@RequestParam int tradeid,@RequestBody Trade_Dtls traders)
	{
		Optional<Trade_Dtls> opt=traderepo.findById(tradeid);
		if(opt.isPresent())
		{
			return traderepo.save(traders);
		}
		else
		{
			return null;
		}
	}

    
    
    @DeleteMapping("/deleteTraderbyid")
	public String deletetardebyid(@RequestParam int tradeid)
	{
		Optional<Trade_Dtls> opt=traderepo.findById(tradeid);
		if(opt.isPresent())
		{
			Trade_Dtls traders=opt.get();
			traderepo.delete(traders);
			return "trader delete to given tradeid";
		}
		else
		{
			return "There is no trader to delete";
		}
	}

    @GetMapping("/{gettradebyid}")
    public Trade_Dtls gettradebyid(@PathVariable ("gettradebyid") int tradeid)
    {
    	
    	return traderepo.getById(tradeid);
    }

     }
 
  
    

   	
    
    
    
    
