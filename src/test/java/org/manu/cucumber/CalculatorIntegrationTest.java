package org.manu.cucumber;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:cucumber.xml" })
public class CalculatorIntegrationTest {
	public static String URL = "http://localhost:9999/SpringCucumber/calculator/add/";

	protected RestTemplate restTemplate = new RestTemplate();

	private long sum;

	@Given("^A Calculator$")
	public void a_Calculator() throws Throwable {

	}

	@When("^the user add (\\d+) and (\\d+)$")
	public void the_user_add_and(final long arg1, final long arg2)
			throws Throwable {

		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		final HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

		final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
				.queryParam("num1", arg1).queryParam("num2", arg2);

		final HttpEntity<Long> response = this.restTemplate.exchange(builder.build()
				.toUri(), HttpMethod.GET, httpEntity, Long.class);

		this.sum = response.getBody();

	}

	@Then("^returns (\\d+) as the sum$")
	public void returns_as_the_sum(final long arg1) throws Throwable {
		Assert.assertThat(arg1, CoreMatchers.equalTo(this.sum));
	}

}
