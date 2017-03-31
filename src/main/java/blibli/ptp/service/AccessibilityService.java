package blibli.ptp.service;

import java.util.List;

import blibli.ptp.dto.AccessibilityDTO;

public interface AccessibilityService {
	public boolean save(AccessibilityDTO dto) throws Exception;
	public boolean update(AccessibilityDTO dto) throws Exception;
	public AccessibilityDTO getAccessibilityById(String id) throws Exception;
	public List<AccessibilityDTO> getListAccessibility() throws Exception;
	public boolean deleteById(String id) throws Exception;
}
